import React from 'react';



import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import TextField from '../atoms/store-TextFieldAtom';
import Typography from '../atoms/store-TypographyAtom';
import LockOutlinedIcon from '../atoms/store-LockOutlinedIcon';
import Avatar from '../atoms/store-AvatarAtom';
import CssBaseline from '../atoms/store-CssBaseline';
import Button from '../atoms/store-SignInButton';
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
  const handleOnAction="";

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