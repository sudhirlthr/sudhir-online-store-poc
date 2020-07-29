import React from 'react';
import Box from '@material-ui/core/Box';

export default function Inline(props) {
  const subject = props.subject;
  return (
    <div style={{ width: '100%' }}>
      <Box component="div" display="inline" p={1} m={1} bgcolor="background.paper">
        {subject}
      </Box>
    </div>
  );
}