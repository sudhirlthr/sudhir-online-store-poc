import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import StoreBox from './store-BoxAtom';
import BuyButton from './store-ButtonAtom';

const useStyles = makeStyles({
  root: {
    maxWidth: 330,
  },
});

export default function ImgMediaCard(props) {
  const classes = useStyles();
  const handleOnBuy = props.handleOnBuy;
  let product = props["product"];
  if( product === undefined) return(<div></div>);

  return (
    <Card className={classes.root}>
      <CardActionArea>
        <CardMedia
          component="img"
          alt={product["productTitile"]}
          height='auto'
          image={product["imageurl"]}
          title={product["productTitile"]}
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
          {product["productTitile"]}
          </Typography><StoreBox subject={"Rating: "+product["rating"]}/>
          <Typography variant="body2" color="textSecondary" component="p">
          {product["description"]}
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
        <BuyButton handleOnBuy={handleOnBuy} productId={product["productId"]} isSold={product["sold"]} deliveryTime={product["deliveryTime"]}/>
      </CardActions>
    </Card>
  );
}