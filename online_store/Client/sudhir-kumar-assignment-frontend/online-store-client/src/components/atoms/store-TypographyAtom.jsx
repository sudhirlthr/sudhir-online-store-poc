import React from 'react';
import Typography from '@material-ui/core/Typography';

export default function storeTypography(props){
    const component = props.component;
    const variant = props.variant;
    const subject = props.subject;

    return(
        <Typography variant={variant} component={component} >
            {subject}
        </Typography>
    );
}