import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';
import StoreBox from './store-BoxAtom';
import Storecard from './store-CardAtoms';

const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
    flexWrap: 'wrap',
    justifyContent: 'space-around',
    overflow: 'hidden',
    backgroundColor: theme.palette.background.paper,
  },
  gridList: {
    width: 1000,
    height: 'auto',
  },
  icon: {
    color: 'rgba(255, 255, 255, 0.54)',
  },
}));

export default function TitlebarGridList(props) {
  const classes = useStyles();
  const handleOnBuy = props["handleOnBuy"];
  const products = props["products"];
  if( products === undefined) return(<div></div>);

  return (
    <div className={classes.root}>
      <GridList cellHeight={1200} className={classes.gridList} cols={3}>
        {products.map((product) => (
          <Storecard product={product} handleOnBuy={handleOnBuy}/>
        ))}
      </GridList>
    </div>
  );
}
