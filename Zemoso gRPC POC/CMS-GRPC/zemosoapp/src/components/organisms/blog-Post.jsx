import React from 'react';
import Post from '../molecules/blog-Form';
import GetAllPosts from '../molecules/blog-GetAllPosts'
import AboutMe from '../molecules/blog-AboutMe';

export default function Posts(){

    
    return(
        <div>
            <GetAllPosts/>
            <AboutMe />
        </div>
        );
}