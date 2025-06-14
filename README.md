# Website

This website is built using [Docusaurus](https://docusaurus.io/), a modern static website generator.

## Getting Started

### Installation

```bash
yarn
```

### Local Development

```bash
yarn start
```

This command starts a local development server and opens up a browser window. Most changes are reflected live without having to restart the server.

### Build

```bash
yarn build
```

This command generates static content into the `build` directory and can be served using any static contents hosting service.

### Deployment

Using SSH:

```bash
USE_SSH=true yarn deploy
```

Not using SSH:

```bash
GIT_USER=<Your GitHub username> yarn deploy
```

If you are using GitHub pages for hosting, this command is a convenient way to build the website and push to the `gh-pages` branch.

## 添加一个文档 sidebar 的过程

1. 在 docs/ 目录中添加目录
2. 在 sidebars.ts 中添加 sidebar 定义
3. 在 docusaurus.config.ts 文件中添加进去

## 添加右侧一个页面的过程
