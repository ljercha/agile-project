import axios from 'axios';
import ProductValidator from './productValidator.js';
import Product from '../model/product.js';

export default class ProductService {
  private productValidator: ProductValidator;

  public apiUrl = `${process.env.API_URL}`;

  constructor(productValidator: ProductValidator) {
    this.productValidator = productValidator;
  }

  async getProducts(): Promise<Product[]> {
    try {
      const response = await axios.get(`${this.apiUrl}/api/products`);

      return response.data;
    } catch (e) {
      throw new Error('Could not get products');
    }
  }

  async createProduct(product: Product): Promise<Product> {
    const validateError = this.productValidator.validateProduct(product);
    if (validateError) {
      console.log(`VALIDATION ERROR: ${validateError}`);
      throw new Error(validateError);
    }

    try {
      const response = await axios.post(`${this.apiUrl}/api/products`, product);

      return response.data;
    } catch (e) {
      throw new Error('Could not create product');
    }
  }

  async getProductById(id: number): Promise<Product> {
    try {
      const response = await axios.get(`${this.apiUrl}/api/products/${id}`);

      return response.data;
    } catch (e) {
      throw new Error('Product not found');
    }
  }
}
