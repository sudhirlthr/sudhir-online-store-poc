import React from 'react'

import { ValidatorForm, TextValidator} from 'react-material-ui-form-validator';

export default function FormValidator(props){
const submit = props.submit;
return(
    <ValidatorForm
        onSubmit={submit}
        onError={errors => console.log(errors)}
    ></ValidatorForm>
);

}