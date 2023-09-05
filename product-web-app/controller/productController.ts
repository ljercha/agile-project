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

    app.get('/add-product-name', async (req: Request, res: Response) => {
      if (!req.session.product) {
        req.session.product = {};
      }
      res.render('add-product-name');
    });
    app.post('/add-product-name', async (req: Request, res: Response) => {
      req.session.product!.name = req.body.name;
      res.redirect('/add-product-description');
    });

    app.get('/add-product-description', async (req: Request, res: Response) => {
      res.render('add-product-description');
    });
    app.post('/add-product-description', async (req: Request, res: Response) => {
      req.session.product!.description = req.body.description;
      res.redirect('/add-product-price');
    });

    app.get('/add-product-price', async (req: Request, res: Response) => {
      res.render('add-product-price');
    });
    app.post('/add-product-price', async (req: Request, res: Response) => {
      req.session.product!.price = req.body.price;
      res.redirect('/add-product-confirmation');
    });

    app.get('/add-product-confirmation', async (req: Request, res: Response) => {
      res.render('add-product-confirmation', req.session.product);
    });
    app.post('/add-product-confirmation', async (req: Request, res: Response) => {
      const data: Partial<Product> | undefined = req.session.product;

      try {
        const newProduct = await this.productService.createProduct(data as Product);
        req.session.product = undefined;
        res.redirect(`/products/${newProduct.productId}`);
      } catch (e: any) {
        console.error(e);
        res.locals.errormessage = e.message;
        res.render('add-product-confirmation', req.session.product);
      }
    });
  }
}
