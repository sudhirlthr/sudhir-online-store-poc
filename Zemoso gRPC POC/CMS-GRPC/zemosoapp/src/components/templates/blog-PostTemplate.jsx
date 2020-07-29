import React from 'react';

import NavBar from "../../utils/NavBar";
import { Router, Route, Switch } from "react-router-dom";
import Profile from "../../utils/Profile";
import history from "../../utils/history";
import PrivateRoute from "../../utils/PrivateRoute";

import Posts from '../organisms/blog-Post';

export default function PostTemplate() {
    return (
        <div>
            {
                <Router history={history}>
                    <header>
                        <NavBar />
                    </header>
                    <Switch>
                        <Route path="/" exact />
                        <PrivateRoute path="/profile" component={Profile} />
                    </Switch>
                </Router>
                // <div>
                //     <Posts />
                // </div>
            }
        </div>
    );
}