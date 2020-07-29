import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Typography from '@material-ui/core/Typography';
import StoreBox from '../atoms/store-BoxAtom';
import BuyButton from '../atoms/store-ButtonAtom';

const useStyles = makeStyles({
  root: {
    maxWidth: 330,
  },
});

const defaultProps = {
  bgcolor: 'background.paper',
  borderColor: 'text.primary',
  m: 10,
  border: 1,
  style: { width: '35rem', height: '25rem' },
};

export default function ImgMediaCard(props) {
  const classes = useStyles();
  const handleOnBuy = props.handleOnBuy;
  let product = props["product"];
  if( product === undefined) return(<div></div>);

  const details = props.details;
  const productId = product["productId"];
  const cardApi = window.location.href+"about/"+productId;

  if(details){
    return (
          <>
             <Card className={classes.root} key={product["productId"]} borderRadius="borderRadius" {...defaultProps}>
            <CardActionArea >
              <CardMedia
                component="img"
                alt={product["productTitile"]}
                height='auto'
                image={product["imageurl"]}
                title={product["productTitile"]}
              />
              <CardContent>
                <Typography gutterBottom variant="h5" component="h2" noWrap className={classes.heading}>
                  {product["productTitile"]}
                </Typography>            
              </CardContent>
            </CardActionArea>
         </Card>
          </>
        );
  }else{
    return (
          <Card className={classes.root} key={product["productId"]} borderRadius="borderRadius" {...defaultProps}>
            <CardActionArea >
            <a href={cardApi} target="_blank">
              <CardMedia
                component="img"
                alt={product["productTitile"]}
                height='auto'
                image={product["imageurl"]}
                title={product["productTitile"]}
              />
              <CardContent>
                <Typography gutterBottom variant="h5" component="h2" noWrap className={classes.heading}>
                {product["productTitile"]}
                </Typography>
                <StoreBox subject={"Rating: "+product["rating"]}/>              
              </CardContent>
              </a>
            </CardActionArea>
          <BuyButton handleOnBuy={handleOnBuy} productId={product["productId"]} isSold={product["sold"]} deliveryTime={product["deliveryTime"]}/>
        </Card>
      );
  }
}