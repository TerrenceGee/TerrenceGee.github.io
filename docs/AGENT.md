# AGENTS.md

## Project Overview

This repository is my personal GitHub Pages website.

The site is based on the Astrofy template, a free and open-source personal portfolio template built with Astro and TailwindCSS.

The goal is to customize Astrofy into a serious, professional engineering portfolio for:

- software engineering opportunities
- data engineering opportunities
- AI infrastructure / research engineering opportunities
- future graduate school or research-group communication
- long-term personal technical branding

This website should not look like a casual personal blog or a flashy frontend demo.

It should look like a clean, credible, engineering-oriented professional homepage.

---

## Owner Profile

Name: Terrence Gee

GitHub handle: terrence1337

Target positioning:

> Backend Engineer · Data Engineering · AI Infrastructure

Alternative longer positioning:

> Software engineer focused on backend systems, data engineering, AI infrastructure, and large-scale information extraction.

Current background summary:

- Backend software engineer
- Experience with Java backend development
- Experience with Python data processing
- Experience with Elasticsearch, Docker, Linux, SQL, DuckDB, PyArrow, Polars
- Interested in data engineering, AI infrastructure, research engineering, information extraction, and financial/industrial data systems
- Undergraduate background: Marine Engineering, Wuhan University of Technology

Important instruction:

Do not invent achievements, publications, employers, awards, metrics, degrees, or project results.

Use placeholders when information is missing.

---

## Website Goal

The website should answer these questions within 30 seconds:

1. Who is Terrence Gee?
2. What kind of engineer is he?
3. What projects has he worked on?
4. What technical areas is he focused on?
5. Where is his CV?
6. How can people contact him?

The website should be useful for:

- recruiters
- technical hiring managers
- research supervisors
- open-source collaborators
- graduate admission reviewers
- future business or startup contacts

---

## High-Level Site Structure

Keep the website simple.

Required top-level pages:

- Home
- Projects
- Writing
- CV
- About
- Contact

Optional later pages:

- Notes
- Reading
- Research
- Uses

Do not add unnecessary pages.

Remove or hide the Store section from Astrofy.

---

## Navigation Requirements

The main navigation should contain:

```text
Home
Projects
Writing
CV
About
Contact
````

Do not include:

```text
Store
Shop
Products
Services
Newsletter
```

unless explicitly requested later.

---

## Language

Use English as the primary language.

Tone:

* professional
* concise
* clear
* calm
* engineering-oriented
* globally understandable

Avoid:

* exaggerated marketing language
* casual jokes
* too many emojis
* overconfident claims
* fake startup-style buzzwords
* unnecessary Chinese text in the first version

Chinese content may be added later as a secondary version, but not in the first version.

---

## Visual Style

Desired style:

* clean
* minimal
* serious
* technical
* readable
* low visual noise
* enough whitespace
* strong typography
* suitable for engineers and researchers

Avoid:

* flashy animations
* too many colors
* cute illustrations
* emoji-heavy design
* overly personal lifestyle-blog appearance
* complex frontend effects
* unnecessary JavaScript

The website should feel closer to:

* engineering portfolio
* research engineer homepage
* technical founder homepage

Not:

* influencer landing page
* lifestyle blog
* frontend animation showcase

---

## Technical Stack

Base template:

* Astrofy

Expected stack:

* Astro
* TypeScript if already used
* TailwindCSS
* Markdown / MDX
* GitHub Pages
* GitHub Actions

Do not introduce heavy dependencies unless necessary.

Avoid adding:

* complex UI libraries
* backend services
* databases
* authentication
* CMS
* analytics requiring accounts
* paid services

This should remain a static website.

---

## Deployment Target

Primary deployment target:

```text
https://terrencegee.github.io
```

Repository name should ideally be:

```text
terrencegee.github.io
```

If the repository is not a user/organization GitHub Pages root repository, configure Astro `site` and `base` correctly.

Use GitHub Actions for deployment.

Follow Astro official GitHub Pages deployment conventions.

Expected checks before completion:

```bash
npm install
npm run build
npm run preview
```

Do not mark the task as done if the project does not build.

---

## Content Principles

### Very Important

Do not fabricate any information.

If a project detail, metric, employer, date, or achievement is unknown, use a placeholder like:

```text
TODO: add verified details
```

or write conservatively.

Allowed:

```text
Built a data processing pipeline for large-scale academic metadata.
```

Not allowed unless verified:

```text
Processed 1B+ records in production for global users.
```

Allowed:

```text
Worked on Elasticsearch indexing and query optimization.
```

Not allowed unless verified:

```text
Reduced query latency by 90%.
```

---

## Homepage Requirements

The homepage should contain these sections:

1. Hero
2. Selected Projects
3. Technical Focus
4. Writing
5. CV / Resume CTA
6. Contact CTA

---

## Homepage Hero Draft

Use or adapt this:

```text
Terrence Gee

Backend Engineer · Data Engineering · AI Infrastructure

I build reliable data systems for research, finance, and industrial intelligence.

View Projects · Read Writing · Download CV
```

Alternative version:

```text
Terrence Gee

Software engineer focused on backend systems, data engineering, AI infrastructure, and large-scale information extraction.

I design and build reliable data pipelines, search systems, and extraction workflows for complex information systems.
```

Keep it concise.

Do not make the hero overly dramatic.

---

## Homepage Selected Projects

Add 3–5 selected projects.

Initial project candidates:

1. OpenAlex Data Pipeline

Use conservative descriptions.

---

## Project Card Format

Each project card should include:

* title
* one-sentence description
* tech stack
* status
* links if available
* short highlights

Example:

```text
OpenAlex Data Pipeline

A large-scale academic metadata processing and indexing pipeline built with Python, DuckDB, PyArrow, and Elasticsearch.

Tech Stack:
Python · DuckDB · PyArrow · Elasticsearch · Docker · Linux

Highlights:
- Processed academic metadata from OpenAlex
- Built data transformation and indexing workflows
- Worked on Elasticsearch index design for large-scale author and work records

Status:
Active / In Progress
```

If links are missing, use:

```text
TODO: add GitHub link
```

---

## Projects Page Requirements

The Projects page should be more detailed than the homepage.

Each project should have:

```text
Title
Problem
Solution
Tech Stack
Engineering Highlights
Current Status
Repository Link
Related Writing
```

Use case-study style.

Avoid vague descriptions.

Prefer:

```text
Designed a data pipeline to transform heterogeneous metadata into searchable indexes.
```

Avoid:

```text
Made a cool data project.
```

---

## Suggested Projects Content

### 1. OpenAlex Data Pipeline

Description:

```text
A data engineering pipeline for processing, transforming, and indexing large-scale academic metadata from OpenAlex.
```

Tech stack:

```text
Python · DuckDB · PyArrow · Polars · Elasticsearch · Docker · Linux
```

Potential highlights:

```text
- Processed large-scale author and work metadata
- Built batch transformation workflows
- Designed Elasticsearch indexing strategy
- Worked with Parquet, JSONL, and offline server environments
```

Do not add exact numbers unless verified in the repository or provided by the owner.

---

## Writing Page Requirements

The Writing page should contain technical notes and essays.

Suggested categories:

* Data Engineering
* Search Systems
* AI Infrastructure
* Backend Engineering
* Engineering Notes

Suggested article titles:

```text
Elasticsearch Shard Design for Large-scale Metadata
Building Offline Python Environments on CentOS
DuckDB vs Polars for Large-scale Data Processing
Designing a Data Fusion System
Recovering Failed LLM Batch Extraction Jobs
Processing OpenAlex Metadata with PyArrow and Parquet
```

Writing can start with placeholders.

Do not migrate all old blog posts immediately.

Only migrate high-quality or relevant posts.

---

## CV Page Requirements

The CV page should be concise and professional.

Sections:

```text
Profile
Experience
Selected Projects
Technical Skills
Education
Languages
Download PDF
Contact
```

Do not create a very long online CV.

The website CV is a preview.

A downloadable PDF CV can be linked later.

Use placeholder if PDF is not available:

```text
TODO: add downloadable PDF CV
```

---

## CV Profile Draft

Use or adapt this:

```text
Backend engineer with experience in software development, data processing, and search systems. Focused on building reliable backend services, data pipelines, and AI infrastructure for research, finance, and industrial information systems.
```

Alternative:

```text
Software engineer focused on backend systems, data engineering, and AI infrastructure. Experienced in Java backend development, Python data processing, Elasticsearch indexing, Docker-based deployment, and large-scale information extraction workflows.
```

---

## Skills Section

Suggested skill categories:

### Programming

```text
Python
Java
SQL
C/C++ basics if appropriate
```

### Data Engineering

```text
DuckDB
PyArrow
Polars
Pandas
Parquet
JSONL
ETL
Data Cleaning
```

### Search / Storage

```text
Elasticsearch
SQL Databases
Index Design
Batch Processing
```

### Infrastructure

```text
Docker
Linux
Git
Shell
WSL
Offline Deployment
```

### AI / LLM Workflow

```text
LLM-based Information Extraction
Prompted Data Extraction
Structured Output Validation
```

Only include skills the owner is comfortable defending in an interview.

---

## About Page Requirements

The About page should explain background, but not become too personal.

Suggested structure:

```text
I am a software engineer focused on backend systems, data engineering, and AI infrastructure.

My work is centered on building reliable systems for extracting, transforming, indexing, and analyzing complex data.

I have a background in marine engineering and several years of software development experience. This gives me an interest in systems that connect engineering, industrial data, research data, and financial information.

Current interests:
- Data engineering
- AI infrastructure
- Research engineering
- Information extraction
- Search systems
- Financial and industrial data systems
```

Avoid:

* long life story
* emotional self-introduction
* exaggerated ambition
* sensitive personal details

---

## Contact Page Requirements

Include:

```text
GitHub
Email
LinkedIn if available
CV download link
```

Do not expose private phone number or personal address.

If email is not confirmed, use:

```text
TODO: add public contact email
```

---

## SEO Requirements

Set site title:

```text
Terrence Gee | Data Engineering & AI Infrastructure
```

Alternative:

```text
Terrence Gee | Software Engineer
```

Meta description:

```text
Software engineer focused on backend systems, data engineering, AI infrastructure, and large-scale information extraction.
```

Use correct Open Graph metadata if Astrofy already supports it.

Do not over-optimize SEO.

---

## Repository Hygiene

Before making changes:

1. Inspect the current repository structure.
2. Identify Astrofy-specific config files.
3. Identify existing content files.
4. Identify navigation config.
5. Identify whether the project uses Markdown, MDX, JSON, or TypeScript config for content.

Do not randomly rewrite the entire project.

Prefer small, reviewable changes.

---

## Editing Rules

Make changes in small steps.

Recommended order:

1. Remove or hide Store section
2. Update site metadata
3. Update navigation
4. Update homepage hero
5. Update project cards
6. Update Projects page
7. Update CV page
8. Update About page
9. Update Contact page
10. Configure GitHub Pages deployment
11. Run build and fix errors

Do not do a massive rewrite in one step unless explicitly requested.

---

## Commit Style

Use clear commit messages.

Examples:

```text
chore: remove store section
content: update homepage positioning
content: add initial project descriptions
content: add cv page draft
deploy: configure github pages workflow
style: simplify portfolio visual style
```

---

## GitHub Pages Deployment

Use GitHub Actions.

Expected workflow file:

```text
.github/workflows/deploy.yml
```

The workflow should:

1. Check out the repository
2. Install dependencies
3. Build the Astro site
4. Upload the generated site artifact
5. Deploy to GitHub Pages

Do not use unsupported deployment hacks.

Do not commit generated build output unless the chosen deployment strategy explicitly requires it.

---

## Astro Config Notes

If deploying to:

```text
https://terrencegee.github.io
```

and the repository is:

```text
terrencegee.github.io
```

then base is usually not needed.

If deploying to:

```text
https://terrencegee.github.io/some-repo/
```

then configure:

```ts
site: "https://terrence1337.github.io",
base: "/some-repo"
```

Check Astro documentation before changing this.

---

## Build Commands

Use existing package manager if lockfile exists.

If `package-lock.json` exists:

```bash
npm install
npm run build
npm run preview
```

If `pnpm-lock.yaml` exists:

```bash
pnpm install
pnpm build
pnpm preview
```

If `yarn.lock` exists:

```bash
yarn install
yarn build
yarn preview
```

Do not change package manager unless necessary.

---

## Validation Checklist

Before final response, verify:

```text
[ ] Site builds successfully
[ ] Navigation works
[ ] Store section removed or hidden
[ ] Homepage has correct positioning
[ ] Projects page exists
[ ] Writing page exists
[ ] CV page exists
[ ] About page exists
[ ] Contact page exists
[ ] No fake achievements added
[ ] No private information exposed
[ ] GitHub Pages workflow exists
[ ] README or project documentation updated if needed
[ ] Mobile layout is acceptable
```

---

## Do Not Do

Do not:

* invent work experience
* invent education credentials
* invent publications
* invent awards
* invent metrics
* add fake testimonials
* add fake clients
* add fake startup traction
* add fake open-source stars
* add private phone number
* add home address
* add unnecessary animations
* add complex dependencies
* turn the website into a frontend showcase
* overcomplicate the information architecture
* migrate all old blog posts at once
* delete old content without confirmation or backup

---

## Content Quality Bar

Every public-facing sentence should be:

* true
* concise
* professional
* defensible in an interview
* useful to a recruiter, engineer, or researcher

If something sounds impressive but cannot be defended, rewrite it conservatively.

---

## Final Desired Result

The final website should feel like:

```text
A serious software engineer's portfolio focused on backend systems, data engineering, AI infrastructure, and large-scale information extraction.
```

It should not feel like:

```text
A generic template with the name changed.
```

It should make Terrence look:

* technically serious
* globally oriented
* engineering-focused
* trustworthy
* capable of building real systems
