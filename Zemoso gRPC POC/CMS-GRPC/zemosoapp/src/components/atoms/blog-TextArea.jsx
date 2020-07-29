import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';

const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
      width: '25ch',
    },
  },
}));

export default function BasicTextFields(props) {
  const classes = useStyles();
  const content = props.ref;

  return (
    <form className={classes.root} noValidate autoComplete="off">
      <TextField id="outlined-multiline-static"
          label="Blog Description"
          multiline
          rows={10}
          columns={10}
          defaultValue=""
          variant="outlined" ref={content}
          required="true"
          />
    </form>
  );
}