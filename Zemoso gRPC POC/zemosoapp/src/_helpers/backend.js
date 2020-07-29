import { Logincms, Blog, DeletePost, Grpcsocialuser, Usercredential } from '../cms_pb';
import { CmsBlogClient } from '../cms_grpc_web_pb';

export function configureFakeBackend() {
    let users = [{ id: 1, username: 'test', password: 'test', firstName: 'Test', lastName: 'User' }];
    let realFetch = window.fetch;
    window.fetch = function (url, opts) {


        return new Promise((resolve, reject) => {
            // wrap in timeout to simulate server api call
            setTimeout(() => {
                // authenticate - public
                if (url.endsWith('/users/authenticate') && opts.method === 'POST') {
                    const params = JSON.parse(opts.body);


                    var client = new CmsBlogClient('http://localhost:51053');
                    var request = new Usercredential();
                    request.setUsername(params.username);
                    request.setPassword(params.password);
                    client.login(request, {}, (err, response) => {
                        console.log(response.getFirstname());
                        const user = {
                            id : response.getUserid(),
                            username: response.getEmail(),
                            firstName: response.getFirstname(),
                            lastName: response.getLastname(),
                            token: response.getToken()
                        };
                        users.push(user);
                        console.log(users);

                    });
                    console.log(users);
                    const user = users.find(x => x.username === params.username);
                    if (!user) return error('Username or password is incorrect');
                    return ok({
                        id: user.id,
                        username: user.username,
                        firstName: user.firstName,
                        lastName: user.lastName,
                        token: user.token
                    });
                }

                // get users - secure
                /*if (url.endsWith('/users') && opts.method === 'GET') {
                    if (!isLoggedIn) return unauthorised();
                    return ok(users);
                }*/

                // pass through any requests not handled above
                realFetch(url, opts).then(response => resolve(response));

                // private helper functions

                function ok(body) {
                    resolve({ ok: true, text: () => Promise.resolve(JSON.stringify(body)) })
                }

                function unauthorised() {
                    resolve({ status: 401, text: () => Promise.resolve(JSON.stringify({ message: 'Unauthorised' })) })
                }

                function error(message) {
                    resolve({ status: 400, text: () => Promise.resolve(JSON.stringify({ message })) })
                }
            }, 500);
        });
    }
}