import { expect } from 'chai';

import { validateProduct } from './productValidator.js';
import Product from '../model/product.js';

describe('Product validator', () => {
  it('expect too long length message', () => {
    const product: Partial<Product> = {
      name: 'aa aaa a a a a a a a aa aaa a a a a a a a aa aaa a a a a a a a aa aaa a a a a a a a aa aaa a a a a a a a ',
    };

    expect(validateProduct(product as Product)).to.be.equal('Name greater than 50 characters');
  });

  it('expect no errrors', () => {
    const product: Product = {
      name: 'Macbook 14 Pro 2021',
      productId: 53,
      description: 'new macbook',
      price: 12,
    };

    expect(validateProduct(product)).to.be.null;
  });
});
