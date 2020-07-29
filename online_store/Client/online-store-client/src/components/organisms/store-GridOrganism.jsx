import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';

import Card from '../molecules/store-CardMolecule';
import Paper from '../atoms/store-PaperAtom'
import GridBorder from '../atoms/store-Border';

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 10,
  },
  paper: {
    padding: theme.spacing(2),
    textAlign: 'center',
    color: theme.palette.text.secondary,
  },
}));

export default function AutoGrid(props) {
  const classes = useStyles();
  const product = props.product;
  const handleOnBuy = props.handleOnBuy;

  return (
    <div className={classes.root}>
      <Grid container spacing={3}>
          <Card product={product} details={true}/>
          <GridBorder />
          <Paper product={product} handleOnBuy={handleOnBuy}/>
      </Grid>
    </div>
  );
}
