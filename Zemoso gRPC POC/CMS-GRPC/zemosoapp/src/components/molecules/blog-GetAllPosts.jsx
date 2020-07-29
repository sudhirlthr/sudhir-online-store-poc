import React, { useState, useEffect } from 'react';
import '../molecules/css/Molecules.css'
import { Logincms, Blog, Commentlist, Comment } from '../../grpc-pb/cms_pb';
import { CmsBlogClient } from '../../grpc-pb/cms_grpc_web_pb'
import { BehaviorSubject } from 'rxjs';

import '../molecules/css/Molecules.css'
import Search from './blog-Search'
import PostForm from './blog-SubmitPostForm'
import Blogrenderer from './blog-Blogrenderer'



export default function GetAllPosts() {
    const [blogs, setBlogs] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');
    const title = React.useRef();
    const content = React.useRef();
    const currentUserSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('currentUser')));
    let userEmail = 'sudhirlthr@gmail.com';
    if(currentUserSubject.value)
        userEmail = currentUserSubject.value.email;


    function isSearched(searchTerm) {
        return function (blog) {
            return !searchTerm || blog.title.toLowerCase().includes(searchTerm.toLowerCase());
        }
    }

    const onSearchChange = (event) => {
        setSearchTerm(event.target.value);
    }

    const handleOnSubmit = (event) => {
        event.preventDefault();

        var client = new CmsBlogClient('http://localhost:51053');

        var request = new Blog();

        request.setBlogid(123);
        request.setTitle(title.current.value);
        request.setContent(content.current.value);
        //request.setRefuser(this.state.currentUser.username);
        request.setRefuser(userEmail);
        let commentList = new Commentlist();
        request.setComments(commentList);
        request.setCreationdate("2020-03-06");

        // for setting token
        //var token = "Bearer "+this.state.currentUser.token;
        var token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0b2tlbiIsImZpcnN0TmFtZSI6IkFhc2h1dG9zaCIsImxhc3ROYW1lXyI6Ikt1bWFyIiwidXNlcmlkIjoiMyIsImVtYWlsIjoic3VkaGlyLmt1bWFyQHplbW9zb2xhYnMuY29tIn0.WWx7j-Tx0xBkRj_VLA0Wpb3_DhhBPSIhmc24t5g0gZc";


        //let updatedData = [];
        client.create(request, { "Authorization": token }, (err, response) => {
            console.log(response);
        });
        if (!alert('New blog post has been saved!')) { window.location.reload(); }
        //setBlogCreated(true);
    }


    const handleOnComment = (event) => {

        if (event.keyCode === 13 && event.shiftKey === false) {
            const userCommentContent = event.target.value.trim();
            const blogid = event.target.id;

            event.preventDefault();

            let userComment = new Comment();
            userComment.setCommentsid(123);
            userComment.setContent(userCommentContent);
            userComment.setCommentsdate(Date.now());
            userComment.setBlogid(blogid);
            //userComment.setRefuser(this.state.currentUser.username);
            userComment.setRefuser(userEmail);

            var client = new CmsBlogClient('http://localhost:51053');
            // for setting token
            //var token = "Bearer "+this.state.currentUser.token;
            var token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0b2tlbiIsImZpcnN0TmFtZSI6IkFhc2h1dG9zaCIsImxhc3ROYW1lXyI6Ikt1bWFyIiwidXNlcmlkIjoiMyIsImVtYWlsIjoic3VkaGlyLmt1bWFyQHplbW9zb2xhYnMuY29tIn0.WWx7j-Tx0xBkRj_VLA0Wpb3_DhhBPSIhmc24t5g0gZc";


            //let updatedData = [];
            client.postcomment(userComment, { "Authorization": token }, (err, response) => {
                console.log(response);
            });
            if (!alert('Comments saved!')) { window.location.reload(); }
            //setBlogCreated(true);
        }

    }

    useEffect(() => {
        const fetchData = async () => {
            var client = new CmsBlogClient('http://localhost:51053');
            var request = new Logincms();
            request.setResponsecode(420);
            request.setResponsemessage("Hello");
            var header = new Headers();
            var token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0b2tlbiIsImZpcnN0TmFtZSI6IkFhc2h1dG9zaCIsImxhc3ROYW1lXyI6Ikt1bWFyIiwidXNlcmlkIjoiMyIsImVtYWlsIjoic3VkaGlyLmt1bWFyQHplbW9zb2xhYnMuY29tIn0.WWx7j-Tx0xBkRj_VLA0Wpb3_DhhBPSIhmc24t5g0gZc";
            await client.post(request, { "Authorization": token }, (err, response) => {
                const outerArray = response;
                {
                outerArray["array"][1].map((dataitem) => {
                    var data = {
                        blogid: dataitem[0],
                        title: dataitem[4],
                        content: dataitem[1],
                        creationdate: dataitem[5],
                        refuser: dataitem[2],
                        comments: dataitem[3]
                    };

                    if (blogs.some(blg => blg.blogid !== data.blogid)) {
                        setBlogs([...blogs, data]);
                    }
                    blogs.push(data);
                })
                }
            });
        };
        fetchData();
    }, [setBlogs]);

    return (
        <div >
            <PostForm title={title} content={content} handleOnSubmit={handleOnSubmit} />
            <div className="interactions">
                <Search
                    value={searchTerm}
                    onChange={onSearchChange}
                >
                </Search>
            </div>
            <div  >
                <div >
                    {
                        blogs.filter(isSearched(searchTerm)).map(blog =>
                            <div key={blog.blogid} >
                                <Blogrenderer blog={blog} handleOnComment={handleOnComment} />
                            </div>
                        )
                    }
                </div>
            </div>
        </div>
    );
}