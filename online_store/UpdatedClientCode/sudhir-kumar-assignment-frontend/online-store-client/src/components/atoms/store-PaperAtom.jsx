import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import { Typography } from '@material-ui/core';
import ListDetails from '../atoms/store-ListAtom';
import BuyButton from '../atoms/store-ButtonAtom';

const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
    flexWrap: 'wrap',
    '& > *': {
      margin: theme.spacing(0),
      width: theme.spacing(120),
      height: theme.spacing(65),
    },
  },
}));

export default function SimplePaper(props) {
  const classes = useStyles();
  const product = props.product;
  const handleOnBuy = props.handleOnBuy;
  

  return (
    <div className={classes.root}>
      <Paper elevation={10} >
        <Typography gutterBottom variant="h4" component="h2" noWrap className={classes.heading}>
            {product["productTitile"]} 
        </Typography>
        <ListDetails subject={product["description"]} />
        <ListDetails subject={"Price: "+product["price"]} />
        <ListDetails subject={"Will get deliver in : "+product["deliveryTime"] +" days"} />
        <BuyButton handleOnBuy={handleOnBuy} productId={product["productId"]} isSold={product["sold"]}/>
      </Paper>
    </div>
  );
}
