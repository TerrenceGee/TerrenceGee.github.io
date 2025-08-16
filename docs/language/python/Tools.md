# Tools

## package manage tool

pip:

```bash
pip install <package_name>
pip freeze (to see installed packages)
pip install -r requirements.txt
```

poetry

## Build tool

| struction | desc |
| --- | --- |
| poetry new <project_name> | |
| poetry init |  |
| poetry install | install all dependencies listed by pyproject.toml |
| poetry add <package_name> | add specified package to pyproject.toml and install it |
| poetry add <package_name> --dev | add it in dev env and install it |
| poetry update |  |
| poetry update --dev |  |
| poetry remove <package_name> |  |
| poetry show |  |
| poetry lock |  |
| poetry build | generate distributed package, include `.tar.gz` and `.whl` |
| poetry publish --build | publish package to specific repo, usually PyPI |
| poetry run <_command> |  |
| poetry run pytest |  |
| poetry help | get helps |
