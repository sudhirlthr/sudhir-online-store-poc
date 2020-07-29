import React from 'react';
import Box from '../atoms/store-GridBox';
import Paper from '../atoms/store-PaperAtom';

export default function BoxMolecule(props){
    const children = props.children;
    return(
        <div>
            <Box>{
                <Paper>
                    {props.chilren}
                </Paper>
                }
            </Box>
        </div>
    );
}