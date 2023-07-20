module.exports = {
  env: {
    browser: true,
    commonjs: true,
    es2021: true,
  },
  extends: [
    'airbnb-base',
    'airbnb-typescript',
  ],
  overrides: [
    {
      env: {
        node: true,
      },
      files: [
        '.eslintrc.{js,cjs}',
      ],
      parserOptions: {
        sourceType: 'script',
      },
    },
    {
      "files": ["*.test.ts", "*.spec.ts"],
      "rules": {
          "@typescript-eslint/no-unused-expressions": "off",
    }
  }
  ],
  parserOptions: {
    project: './tsconfig.json',
    ecmaVersion: 'latest',
  },
  rules: {
    "react/jsx-filename-extension": "off",
  },
};
