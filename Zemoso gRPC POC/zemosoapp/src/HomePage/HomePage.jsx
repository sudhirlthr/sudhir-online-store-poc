import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import { Alert, AlertTitle } from '@material-ui/lab';
import '../App.css'
import Alrt from '../_helpers/alert'

import { userService, authenticationService } from '@/_services';

import { Logincms, Blog, DeletePost, Commentlist, Comment } from '../cms_pb';
import { CmsBlogClient, Metadata } from '../cms_grpc_web_pb'

class HomePage extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            currentUser: authenticationService.currentUserValue,
            users: null,
            blogs: [],
            newdata: [],
            searchTerm: '',
            commentBlogId: 123,
            blogCreated: false,
        };
        this.title = React.createRef();
        this.content = React.createRef();
        this.commentBlogId = React.createRef();
        this.handleOnSubmit = this.handleOnSubmit.bind(this);
        this.handleOnComment = this.handleOnComment.bind(this);
        this.onSearchChange = this.onSearchChange.bind(this);
        this.onDismiss = this.onDismiss.bind(this);
    }

    componentDidMount() {
        userService.getAll().then(users => this.setState({ users }));

        const { searchTerm } = this.state;
        //this.fetchAllPosts(searchTerm);
        var client = new CmsBlogClient('http://localhost:51053');

        var request = new Logincms();

        request.setResponsecode(420);
        request.setResponsemessage("Hello");
        var header = new Headers();
        var token = "Bearer "+this.state.currentUser.token;
        console.log(token);


        client.post(request, {"Authorization": token}, (err, response) => {
            //console.log(response["array"][1][1]);
            const outerArray = response;
            {outerArray["array"][1].map((dataitem) => {
                //console.log({dataitem})

                var updateddata = this.state.blogs.concat({
                    blogid: dataitem[0],
                    title: dataitem[4],
                    content: dataitem[1],
                    creationdate: dataitem[5],
                    refuser: dataitem[2],
                    comments: dataitem[3]
                });
                this.setState({blogs: updateddata})

            })}
        });
    }

    onDismiss(id){
        const isNotId = blog => blog.blogid !== id;
        const updatedList = this.state.blogs.filter(isNotId);
        this.setState({blogs: updatedList});
    }

    onSearchChange(event){
        this.setState({ searchTerm: event.target.value })
    }

    handleOnSubmit(event){
        console.log(this.title.current.value);
        console.log(this.content.current.value);
        event.preventDefault();

        var client = new CmsBlogClient('http://localhost:51053');

        var request = new Blog();

        request.setBlogid(123);
        request.setTitle(this.title.current.value);
        request.setContent(this.content.current.value);
        request.setRefuser(this.state.currentUser.username);
        let commentList = new Commentlist();
        request.setComments(commentList);
        request.setCreationdate("2020-03-06");

        // for setting token
        var token = "Bearer "+this.state.currentUser.token;
        console.log(token);


        //let updatedData = [];
        client.create(request, {"Authorization": token}, (err, response) => {
            console.log(response);
        });
        //if(!alert('New blog post has been saved!')){window.location.reload();}
        this.setState({blogCreated: true})

    }


    handleOnComment(event){

        if (event.keyCode == 13 && event.shiftKey == false){
            const userCommentContent = event.target.value.trim();
            const blogid = event.target.id;

            event.preventDefault();

            let userComment = new Comment();
            userComment.setCommentsid(123);
            userComment.setContent(userCommentContent);
            userComment.setCommentsdate(Date.now());
            userComment.setBlogid(blogid);
            userComment.setRefuser(this.state.currentUser.username);

            var client = new CmsBlogClient('http://localhost:51053');
            // for setting token
            var token = "Bearer "+this.state.currentUser.token;
            console.log(token);


            //let updatedData = [];
            client.postcomment(userComment, {"Authorization": token}, (err, response) => {
                console.log(response);
            });
            //if(!alert('Comments saved!')){window.location.reload();}
            this.setState({blogCreated: true})
        }

    }

    render() {
        const { currentUser, users, searchTerm, blogs, blogCreated } = this.state;
        if(blogCreated){
            return (
                <Alrt click={this.componentDidMount}/>
            );
        }else {
            return (
                        <div className="page">
                            <form onSubmit={this.handleOnSubmit} className="row">
                                <div className="row">
                                    <input type="text" ref={this.title} placeholder="Blog Title"  required/><br/>
                                    <textarea ref={this.content} placeholder="Blog description" rows="5" cols="40" required/>
                                    <button className="button2" type="submit" >Submit</button>
                                </div>
                            </form><br/>
                            <div className="interactions">
                                <Search
                                    value = {searchTerm}
                                    onChange = {this.onSearchChange}
                                >
                                </Search>
                            </div>
                            <div className="row">
                                <div className="leftcolumn">
                                    {
                                        blogs.filter(isSearched(searchTerm)).map(blog =>
                                                <div key={blog.blogid} className="card">
                                                    <h2>{blog.title}</h2>
                                                    <h5>{blog.creationdate}, {blog.refuser}</h5>
                                                    <textarea disabled>{blog.content}</textarea>
                                                    <div>
                                                        {blog.comments[1].map(cmt =>
                                                            <ul className="card2">
                                                                <li>{cmt[1]}</li>
                                                                <li className="card3">{cmt[4]}, {cmt[2]}</li>
                                                            </ul>
                                                        )}

                                                      <form key={blog.blogid} className="card2">
                                                          <textarea rows="1" name="body" onKeyDown={this.handleOnComment} placeholder="Comment here" id={blog.blogid}/>
                                                          <button type="submit" hidden={true} >Submit</button>
                                                      </form>
                                                    </div>

                                                    {/*<span style={{ width: '10%' }}>
                                                      <Button
                                                          onClick={() => this.onDismiss(blog.blogid)}
                                                          type="button"
                                                          className="button-inline"
                                                      >Dismiss
                                                      </Button>

                                                    </span>*/}
                                                </div>
                                        )
                                    }
                                </div>
                                <div className="test">
                                    <div className="card">
                                        <h2>About Me</h2>
                                        <p>{currentUser.firstName +" "+currentUser.lastName}</p>
                                        <p>Software Engineer at Zemoso Technologies Pvt. Ltd.</p>
                                    </div>
                                    <div className="card">
                                        <h3>Follow Me</h3>
                                        <p>Linkedin: <a href="www.linkedin.com/in/sudhirlthr" color="green">sudhirlthr</a></p>
                                        <p>Facebook: <a href="www.facebook.com/sudhirltr" color="green">sudhirltr</a></p>
                                        <p>Twitter: <a href="www.twitter.com/in/sudhirltr" color="green">sudhirltr</a></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    );
        }
    }
}

function isSearched(searchTerm) {
    return function (blog) {
        return !searchTerm || blog.title.toLowerCase().includes(searchTerm.toLowerCase());
    }
}

const Search = ({ value, onChange , children })  =>
    <form>
        {children}
        <input
            type="text"
            onChange={onChange}
            value={value}
            placeholder="Search blog by title"
        />
    </form>

const Table  = ({ blogs, pattern, onDismiss }) =>
    <div className="table" >
        {
            blogs.filter(isSearched(pattern)).map(blog =>
                <div key={blog.blogid} className="table-row">
                    <span style={{ width: '40%' }}>{blog.title}</span>
                    <span style={{ width: '30%' }}>{blog.content}</span>
                    <span style={{ width: '10%' }}>{blog.creationdate}</span>
                    <span style={{ width: '10' }}>{blog.comments}</span>
                    <span style={{ width: '10%' }}>{blog.refuser.email}</span>
                    <span style={{ width: '10%' }}>
                              <Button
                                  onClick={() => onDismiss(blog.blogid)}
                                  type="button"
                                  className="button-inline"
                              >Dismiss
                              </Button>

                          </span>
                </div>
            )
        }
    </div>


const Myblog  = ({ blogs, pattern, onDismiss, users }) =>
    <div className="row">
        <div className="leftcolumn">
            {
                blogs.filter(isSearched(pattern)).map(blog =>
                    <div key={blog.blogid} className="card">
                        <h2>{blog.title}</h2>
                        <h5>{blog.creationdate}, {blog.refuser}</h5>
                        <textarea disabled>{blog.content}</textarea>
                        <div>
                            {blog.comments[1].map(cmt =>
                                <ul className="card2">
                                    <li>{cmt[1]}</li>
                                    <li className="card3">{cmt[4]}</li>
                                </ul>
                            )}
                        </div>

                        <span style={{ width: '10%' }}>
                              <Button
                                  onClick={() => onDismiss(blog.blogid)}
                                  type="button"
                                  className="button-inline"
                              >Dismiss
                              </Button>

                            </span>
                    </div>
                )
            }
        </div>
        <div className="test">
            <div className="card">
                <h2>About Me</h2>
                <p>{users.firstName +" "+users.lastName}</p>
                <p>Software Engineer at Zemoso Technologies Pvt. Ltd.</p>
            </div>
            <div className="card">
                <h3>Follow Me</h3>
                <p>Linkedin: <a href="www.linkedin.com/in/sudhirlthr" color="green">sudhirlthr</a></p>
                <p>Facebook: <a href="www.facebook.com/sudhirltr" color="green">sudhirltr</a></p>
                <p>Twitter: <a href="www.twitter.com/in/sudhirltr" color="green">sudhirltr</a></p>
            </div>
        </div>
    </div>

const Button = ({ onClick, className = '', children }) =>
    <button
        onClick={onClick}
        className={className}
        type="button"
    >
        {children}
    </button>

const useStyles = makeStyles((theme) => ({
  root: {
    width: '100%',
    '& > * + *': {
      marginTop: theme.spacing(2),
    },
  },
}));
export { HomePage };