import axios from 'axios';
import Product from '../model/product.js';
import { validateProduct } from './productValidator.js';

const apiUrl = `http://${process.env.API_URL}`;

export async function getProducts(): Promise<Product[]> {
  try {
    const response = await axios.get(`${apiUrl}/api/products`);

    return response.data;
  } catch (e) {
    throw new Error('Could not get products');
  }
}

export async function createProduct(product: Product): Promise<number> {
  const validateError = validateProduct(product);
  if (validateError) {
    const a = '';
    console.log(`VALIDATION ERROR: ${validateError}`);
    throw new Error(validateError);
  }

  try {
    const response = await axios.post(`${apiUrl}/api/products`, product);

    return response.data;
  } catch (e) {
    throw new Error('Could not create product');
  }
}

export async function getProductById(id: number): Promise<Product> {
  try {
    const response = await axios.get(`${apiUrl}/api/products/${id}`);

    return response.data;
  } catch (e) {
    throw new Error('Could not get products');
  }
}
