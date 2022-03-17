module.exports = {
  '{,src/**/,webpack/}*.{html,css,scss,md,yml,json,java}': [
    'prettier --config .prettierrc --ignore-path .prettierignore --write',
    'cspell --config .cspell.json --unique --no-must-find-files -- --no-summary',
  ],
  '{,src/**/,webpack/}*.{js,jsx,ts,tsx}': [
    'prettier --config .prettierrc --ignore-path .prettierignore --write',
    'cspell --config .cspell.json --unique --no-must-find-files -- --no-summary',
    'eslint --config .eslintrc.json --ignore-path .eslintignore',
  ],
};
