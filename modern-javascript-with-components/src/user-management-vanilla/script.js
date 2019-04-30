document.addEventListener('DOMContentLoaded', () => {
  document.getElementById('new-user-button').addEventListener('click', () => {
    document.getElementById('edit-screen').style.display = 'block';
  });

  document.getElementById('cancel-save').addEventListener('click', (event) => {
    event.preventDefault();
    event.stopPropagation();

    hideForm();
  });

  document.querySelector('#edit-screen form').addEventListener('submit', (event) => {
    event.preventDefault();

    let firstName = event.currentTarget.querySelector('input#firstName').value;
    let lastName = event.currentTarget.querySelector('input#lastName').value;
    let title = event.currentTarget.querySelector('input#title').value;
    let email = event.currentTarget.querySelector('input#email').value;
    let enabled = event.currentTarget.querySelector('input#enabled').checked;

    let newRow = getDomFromTemplate('new-user-row');
    newRow.querySelector('.user-id').innerText = (Math.random() * 1000).toFixed(0);
    newRow.querySelector('.user-name').innerText = firstName + ' ' + lastName;
    newRow.querySelector('.user-title').innerText = title;
    newRow.querySelector('.user-email').innerText = email;
    newRow.querySelector('.user-enabled').innerText = (enabled ? 'Yes' : 'No');

    document.querySelector('table#user-table tbody').appendChild(newRow);

    hideForm();
  });

  document.getElementById('filter').addEventListener('input', (event) => {
    let content = event.currentTarget.value;
    if(content == '') {
      showAllRows();
    } else {
      filterRows(content);
    }
  });
});

function showAllRows() {
  document.querySelectorAll('table#user-table tbody tr').forEach((row) => {
    row.style.display = '';
  });
}

function filterRows(content) {
  document.querySelectorAll('table#user-table tbody tr').forEach((row) => {
    if(row.textContent.includes(content)) {
      row.style.display = '';
    } else {
      row.style.display = 'none';
    }
  });
}

function hideForm() {
  document.getElementById('edit-screen').style.display = 'none';
  document.querySelectorAll('input[type=text]').forEach((field) => {
    field.value = '';
  });
  document.querySelectorAll('input[type=email]').forEach((field) => {
    field.value = '';
  });
  document.querySelectorAll('input[type=checkbox]').forEach((box) => {
    box.checked = false;
  });
}

function getDomFromTemplate(templateId) {
  let t = document.getElementById(templateId);
  return document.importNode(t.content, true);
}