import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import clsx from 'clsx';
import Card from '@material-ui/core/Card';
import CardHeader from '@material-ui/core/CardHeader';
import CardMedia from '@material-ui/core/CardMedia';
import CardContent from '@material-ui/core/CardContent';
import CardActions from '@material-ui/core/CardActions';
import Collapse from '@material-ui/core/Collapse';
import Avatar from '@material-ui/core/Avatar';
import IconButton from '@material-ui/core/IconButton';
import Typography from '@material-ui/core/Typography';
import { red } from '@material-ui/core/colors';
import FavoriteIcon from '@material-ui/icons/Favorite';
import ShareIcon from '@material-ui/icons/Share';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import MoreVertIcon from '@material-ui/icons/MoreVert';

import StoreButton from './store-ButtonAtom';

const useStyles = makeStyles((theme) => ({
  root: {
    maxWidth: 345,
  },
  media: {
    height: 0,
    paddingTop: '56.25%', // 16:9
  },
  expand: {
    transform: 'rotate(0deg)',
    marginLeft: 'auto',
    transition: theme.transitions.create('transform', {
      duration: theme.transitions.duration.shortest,
    }),
  },
  expandOpen: {
    transform: 'rotate(180deg)',
  },
  avatar: {
    backgroundColor: red[500],
  },
}));

export default function StoreCard(props) {
  const classes = useStyles();
  const [expanded, setExpanded] = React.useState(false);

  let product = props["product"];
  if( product === undefined) return(<div></div>);

  const deliveryIn = product["productTitile"];
  
  const handleExpandClick = () => {
    setExpanded(!expanded);
  };

  return (
<Card className={classes.root}>
      <CardHeader
        title={product["productTitile"]}
      />
      <CardMedia
        className={classes.media}
        image={product["imageurl"]}
        title={product["productTitile"]}
      />
      <CardContent>
          
        <Typography variant="body2" color="textSecondary" component="p">
        {product["description"]}
        </Typography>
      </CardContent>
      <CardActions disableSpacing>
        <IconButton aria-label="add to favorites">
          <FavoriteIcon />
        </IconButton>
        <IconButton
          className={clsx(classes.expand, {
            [classes.expandOpen]: expanded,
          })}
          onClick={handleExpandClick}
          aria-expanded={expanded}
          aria-label="show more"
        >
          <ExpandMoreIcon />
        </IconButton>
      </CardActions>
      <Collapse in={expanded} timeout="auto" unmountOnExit>
        <CardContent>
          <Typography paragraph>Product description: <br />
            {product["description"]}
          </Typography>
          <Typography paragraph>Product price: 
            {product["price"]}
          </Typography>
          <Typography paragraph>Will get delivered in: 
            {product["deliveryTime"]} days
          </Typography>
          <StoreButton />
        </CardContent>
      </Collapse>
    </Card>
  );
}
