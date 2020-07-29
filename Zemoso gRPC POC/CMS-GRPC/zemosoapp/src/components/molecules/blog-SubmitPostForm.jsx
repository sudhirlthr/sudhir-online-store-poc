import React from 'react';
import Button from '../atoms/blog-Button';
import { ValidatorForm } from 'react-material-ui-form-validator';



export default function SubmitPost(props) {
    const handleOnSubmit = props.handleOnSubmit;
    const title = props.title;
    const content = props.content;
    return (
            <ValidatorForm

                onSubmit={handleOnSubmit}
                onError={errors => console.log(errors)}
            >
                <input type="text" ref={title} placeholder="Blog Title" required /><br />
                <textarea ref={content} placeholder="Blog description" rows="5" cols="40" required />
                <Button />
            </ValidatorForm>
    );
}