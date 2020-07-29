import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';


import BlogTitleAndContent from '../atoms/blog-TitleAndContentList';
import CommentTag from '../molecules/blog-Comment';

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  paper: {
    padding: theme.spacing(10),
    textAlign: 'center',
    color: theme.palette.text.secondary,
  },
}));

export default function CenteredGrid(props) {
  const classes = useStyles();
  const blog = props.data;
  const handleOnComment = props.handleOnComment;

  return (
    <div className={classes.root}>
      <Grid container spacing={3} justify="center">
        <Grid item xs={5}>
            <Paper className={classes.paper}>
                <BlogTitleAndContent blogid={blog.blogid} title={blog.title} content={blog.content} user={blog.refuser} creationdate ={blog.creationdate}/>
                <CommentTag blog={blog} handleOnComment={handleOnComment}/>
            </Paper>
        </Grid>
      </Grid>
    </div>
  );
}
