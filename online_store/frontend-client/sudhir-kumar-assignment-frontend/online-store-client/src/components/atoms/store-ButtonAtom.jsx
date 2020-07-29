import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import { Typography } from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
    },
  },
}));

export default function StoreButtons(props) {
  const classes = useStyles();
  const handleOnBuy = props.handleOnBuy;
  const productId = props.productId;
  const isSold = props.isSold;
  const deliveryTime = props.deliveryTime;

  if(isSold){
      return(
          <div>
              <Button variant="contained" color="secondary" disabled>
                    Sold
               </Button>
          </div>
      )
  }
  return (
    <div className={classes.root}>
      <Button variant="contained" color="primary" onClick={handleOnBuy} id={productId}>
        Buy
      </Button>
      <Typography variant="caption" display="block" gutterBottom>
             Delivery {deliveryTime} days
      </Typography>
    </div>
  );
}
