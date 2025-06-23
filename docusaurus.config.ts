import { themes as prismThemes } from 'prism-react-renderer';
import type { Config } from '@docusaurus/types';
import type * as Preset from '@docusaurus/preset-classic';

const config: Config = {
  title: 'Terrence Gee',
  tagline: '成熟的代码是思维的体现！',
  favicon: 'img/tg.svg',

  // Set the production url of your site here
  // url: 'https://your-docusaurus-site.example.com',
  url: 'https://terrencegee.github.io',
  // Set the /<baseUrl>/ pathname under which your site is served
  // For GitHub pages deployment, it is often '/<projectName>/'
  // baseUrl: '/',
  baseUrl: '/blog',

  // GitHub pages deployment config.
  // If you aren't using GitHub pages, you don't need these.
  organizationName: 'plain', // Usually your GitHub org/user name.
  projectName: 'blog', // Usually your repo name.
  deploymentBranch: 'deployment',
  trailingSlash: true,

  onBrokenLinks: 'throw',
  onBrokenMarkdownLinks: 'warn',

  // Even if you don't use internationalization, you can use this field to set
  // useful metadata like html lang. For example, if your site is Chinese, you
  // may want to replace "en" with "zh-Hans".
  i18n: {
    defaultLocale: 'en',
    locales: ['en'],
  },

  presets: [
    [
      'classic',
      {
        docs: {
          sidebarPath: './sidebars.ts',
          // Please change this to your repo.
          editUrl:
            'https://github.com/TerrenceGee/blog/tree/source/',
        },
        blog: {
          showReadingTime: true,
          // Please change this to your repo.
          editUrl:
            'https://github.com/TerrenceGee/blog/tree/source/',
        },
        pages: {

        },
        theme: {
          customCss: './src/css/custom.css',
        },
      } satisfies Preset.Options,
    ],
  ],

  themeConfig: {

    // Replace with your project's social card
    image: 'img/docusaurus-social-card.jpg',

    // navbar
    navbar: {
      title: 'Terrence Gee',
      logo: { alt: 'Terrence Gee Logo', src: 'img/tg.svg', },
      items: [
        // left
        { type: 'docSidebar', sidebarId: 'middleware', position: 'left', label: '中间件', },
        { type: 'docSidebar', sidebarId: 'design', position: 'left', label: '设计', },
        { type: 'docSidebar', sidebarId: 'algorithm', position: 'left', label: '算法', },
        { type: 'docSidebar', sidebarId: 'java', label: 'JAVA', position: 'left', },
        { type: 'docSidebar', sidebarId: 'framework', position: 'left', label: '框架', },
        { type: 'docSidebar', sidebarId: 'webApp', position: 'left', label: 'web应用', },
        { type: 'docSidebar', sidebarId: 'operations', position: 'left', label: '运维', },
        { type: 'docSidebar', sidebarId: 'tools', position: 'left', label: '工具', },
        // {
        //   type: 'docSidebar',
        //   sidebarId: 'tutorialSidebar',
        //   position: 'left',
        //   label: 'Tutorial',
        // },
        { type: 'docSidebar', sidebarId: 'cyber', label: 'Cyber', position: 'left', },
        { type: 'docSidebar', sidebarId: 'rust', label: 'Rust', position: 'left', },
        { type: 'docSidebar', sidebarId: 'tips', label: 'Tips', position: 'left', },

        // right
        { type: 'docSidebar', sidebarId: 'workout', label: 'Workout', position: 'right', },
        { type: 'docSidebar', sidebarId: 'plan', label: 'Plan', position: 'right', },
        // blog
        { to: '/blog/blog', label: 'Blog', position: 'right', },
        { to: '/blog/resume', label: 'Resume', position: 'right', },
        { href: 'https://github.com/TerrenceGee', label: 'GitHub', position: 'right', },
      ],
    },

    // footer
    footer: {
      style: 'dark',
      links: [
        {
          title: 'Docs',
          /* items: [
            {
              label: 'Tutorial',
              to: '/docs/intro',
            },
          ], */
        },
        {
          title: 'Community',
          items: [
            /*  {
               label: 'Stack Overflow',
               href: 'https://stackoverflow.com/questions/tagged/docusaurus',
             }, */
            /* {
              label: 'Discord',
              href: 'https://discordapp.com/invite/docusaurus',
            }, */
            /* {
              label: 'Twitter',
              href: 'https://twitter.com/docusaurus',
            }, */
          ],
        },
        {
          title: 'More',
          items: [
            { label: 'Blog', to: '/blog/blog', },
            { label: 'GitHub', href: 'https://github.com/TerrenceGee/blog', },
          ],
        },
      ],
      copyright: `Copyright © ${new Date().getFullYear()} My Project, Inc. Built with Docusaurus.`,
    },
    prism: {
      theme: prismThemes.github,
      darkTheme: prismThemes.dracula,
    },
  } satisfies Preset.ThemeConfig,
};

export default config;
