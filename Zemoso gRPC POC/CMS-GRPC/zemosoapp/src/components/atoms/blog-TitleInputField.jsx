import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';

const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
      width: '20ch',
    },
  },
}));

export default function TitleInputField(props) {
  const classes = useStyles();
  const title = props.ref;

  return (
    <form className={classes.root} noValidate autoComplete="off">
      <TextField id="outlined-basic" label="Title" variant="outlined" ref={title} />
    </form>
  );
}
