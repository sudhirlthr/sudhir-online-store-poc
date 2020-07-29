import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Grid from '../atoms/blog-Grid';

const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
    flexWrap: 'wrap',
    '& > *': {
      margin: theme.spacing(1),
      width: theme.spacing(30),
      height: theme.spacing(20),
    },
  },
}));

export default function SimplePaper(props) {
  const classes = useStyles();
  const blog = props.blog;
  const handleOnComment = props.handleOnComment;

  return (
    <div>
          <Grid data={blog} handleOnComment={handleOnComment}/>
    </div>
  );
}
