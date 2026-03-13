// 방법1
const fs = require('fs').promises;
// 방법2
// const fs = require('fs/promises');

fs.readdir('./')
  .then((files) => {
    console.log(files);
  })
  .catch((err) => {
    console.error(err);
  });


