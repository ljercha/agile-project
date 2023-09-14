import { Application, Request, Response } from 'express';
import ProductService from '../service/productService.js';
import Product from '../model/product.js';
import ProductValidator from '../service/productValidator.js';

export default class ProductController {
  private productService = new ProductService(new ProductValidator());

  appRoutes(app: Application) {
    app.get('/products', async (req: Request, res: Response) => {
      let data: Product[] = [];

      try {
        data = await this.productService.getProducts();
      } catch (e) {
        console.error(e);
      }

      res.render('list-products', { products: data });
    });

    app.get('/products/:id', async (req: Request, res: Response) => {
      let data = {};

      try {
        data = await this.productService.getProductById(Number.parseInt(req.params.id, 10));
      } catch (e) {
        console.error(e);
      }

      res.render('view-product', { product: data });
    });

    app.get('/add-product', async (req: Request, res: Response) => {
      res.render('add-product');
    });

    app.post('/add-product', async (req: Request, res: Response) => {
      const data: Product = req.body;

      try {
        const newProduct = await this.productService.createProduct(data);
        res.redirect(`/products/${newProduct.productId}`);
      } catch (e: any) {
        console.error(e);
        res.locals.errormessage = e.message;
        res.render('add-product', req.body);
      }
    });
  }
}
