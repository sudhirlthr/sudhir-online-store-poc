import React from 'react';

export default function LineEllipse(props){
    const subjectText = props.subject;
    const maxLine = props.maxLine;
    
    return(<LineEllipse 
                text={subjectText}
                maxLine={maxLine}
                ellipsis='...'
                trimRight
                basedOn='letters'
        />)
}