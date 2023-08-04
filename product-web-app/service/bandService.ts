import axios from 'axios';
import Band from '../model/band.js';

const addBand = async (band: Band): Promise<Band> => {
  try {
    const response = await axios.post('http://localhost:8080/api/admin/band', band);
    return response.data;
  } catch (e) {
    throw new Error('Could not create band');
  }
};

export default addBand;
