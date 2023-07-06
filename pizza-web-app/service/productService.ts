import { Product } from "../model/product";
const productValidator = require('./productValidator');
const axios = require('axios');

const apiUrl = `http://${process.env.API_URL}:8080`;

module.exports.getProducts = async function (): Promise<Product[]> {
    try {
        const response = await axios.get(`${apiUrl}/api/products`);

        return response.data;
    }
    catch (e) {
        throw new Error('Could not get products');
    }
}

module.exports.createProduct = async function (product: Product): Promise<number> {
    const validateError = productValidator.validateProduct(product);
        if (validateError) {
            console.log(`VALIDATION ERROR: ${validateError}`);
            throw new Error(validateError);
        }
        
    try {
        const response = await axios.post(`${apiUrl}/api/products`, product);

        return response.data;
    }
    catch (e) {
        throw new Error('Could not create product');
    }
}

module.exports.getProductById = async function (id: number): Promise<Product> {
    try {
        const response = await axios.get(`${apiUrl}/api/products/${id}`);

        return response.data;
    }
    catch (e) {
        throw new Error('Could not get products');
    }
}