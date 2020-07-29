import React from 'react';
import Button from '@material-ui/core/Button';

export default function storeSignInButton(props){
    const type = props.type;
    const handleOnAction = props.handleOnAction;
    const variant = props.variant;
    const color = props.color;
    const className = props.className;
    const subject = props.subject;

    return(<Button type={type} variant={variant} color={color} className={className} onClick={handleOnAction} >
                {subject}
           </Button>);
}