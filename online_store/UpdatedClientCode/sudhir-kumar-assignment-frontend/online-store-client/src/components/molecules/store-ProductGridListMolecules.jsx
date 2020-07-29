import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from './store-CardMolecule';
import Grid from '../atoms/store-GridListAtom';
import Box from '../atoms/store-GridBox';
const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
    flexWrap: 'wrap',
    justifyContent: 'space-around',
    overflow: 'hidden',
    backgroundColor: '#eeeeee',
  },
  gridList: {
    width: 1100,
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
      <Grid cellHeight={1200} className={classes.gridList} cols={3} spacing={8}>
        {products.map((product) => (
                <>
                  <Card product={product} handleOnBuy={handleOnBuy}/>
                  <Box />
                </>
          ))}
      </Grid>
    </div>
  );
}
