import React, { useState } from 'react';
import axios from 'axios';


import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import TextField from '../atoms/store-TextFieldAtom';
import Typography from '../atoms/store-TypographyAtom';
import LockOutlinedIcon from '../atoms/store-LockOutlinedIcon';
import Avatar from '../atoms/store-AvatarAtom';
import CssBaseline from '../atoms/store-CssBaseline';
import Button from '../atoms/store-SignInButton';
import fAuth from '../../utils/store-RouteAuth';
//import Container from '../atoms/store-ContainerAtom';

const useStyles = makeStyles((theme) => ({
  paper: {
    marginTop: theme.spacing(8),
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main,
  },
  form: {
    width: '100%',
    marginTop: theme.spacing(1),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
  },
}));

export default function SignIn() {
  const classes = useStyles();
  const [loginFailed, setLoginFailed] = useState(false);
  const [user, setUsername] = useState("sudhir");
  const [pass, setPassword] = useState("123");

  const handleOnAction = (event) => {
    
    const endpoint = "http://localhost:8080/login";


    const username = user;
    const password = pass;

    console.log(username);
    console.log(password);
    const user_object = {
      username: username,
      password: password
    };

    axios.post(endpoint, user_object).then(res => {
      localStorage.setItem("authorization", res.data.token);
    });

    
  }

  return (
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <div className={classes.paper}>
        <Avatar className={classes.avatar}>
          <LockOutlinedIcon />
        </Avatar>
        <Typography component="h1" variant="h5" subject={"Sign in"} />
        <form className={classes.form} noValidate>
          <TextField
            variant="outlined"
            margin="normal"
            id="email"
            label="Email Address"
            name="email"
            autoComplete="email"
          />
          <TextField
            variant="outlined"
            margin="normal"
            name="password"
            label="Password"
            type="password"
            id="password"
            autoComplete="current-password"
          />
          <Button
            type="submit"
            handleOnAction={handleOnAction}
            variant="contained"
            color="primary"
            className={classes.submit}
            subject={"Sign In"}
          />
        </form>
      </div>
    </Container>
  );
}