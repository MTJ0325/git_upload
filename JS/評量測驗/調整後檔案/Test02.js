let rowCount = 0;
let selectedRow = null;

// 新增一列
function addRow() {
    // 取得使用者輸入的數值，並去除頭尾空白
    const manufacturer = document.getElementById('manufacturer').value.trim();
    const category = document.getElementById('category').value.trim();
    const basePrice = document.getElementById('basePrice').value.trim();
    const sellingPrice = document.getElementById('sellingPrice').value.trim();

    // 檢查製造商和類別是否為空白
    if (!manufacturer || !category) {
        alert('製造商和類別不可空白');
        return;
    }

    // 更新序號
    rowCount++;
    const table = document.getElementById('resultTable').getElementsByTagName('tbody')[0];
    const row = table.insertRow(); // 插入新列

    // 在新的一列的第一格中添加單選按鈕
    const cell1 = row.insertCell(0);
    const radio = document.createElement('input');
    radio.type = 'radio';
    radio.name = 'selectRow';
    radio.onclick = () => selectRow(row); // 點擊單選按鈕時選中該列
    cell1.appendChild(radio);

    // 在新的一列中插入序號、製造商、類別、底價和售價
    row.insertCell(1).textContent = rowCount;
    row.insertCell(2).textContent = manufacturer;
    row.insertCell(3).textContent = category;
    row.insertCell(4).textContent = basePrice;
    row.insertCell(5).textContent = sellingPrice;

    // 在新的一列的最後一格中添加刪除按鈕
    const cell7 = row.insertCell(6);
    const deleteButton = document.createElement('button');
    deleteButton.textContent = '刪除';
    deleteButton.onclick = () => deleteRow(row); // 點擊刪除按鈕時刪除該列
    cell7.appendChild(deleteButton);

    // 清空輸入欄位
    clearFields();
}

// 清空所有輸入欄位
function clearFields() {
    // 清空輸入欄位
    document.getElementById('manufacturer').value = '';
    document.getElementById('category').value = '';
    document.getElementById('basePrice').value = '';
    document.getElementById('sellingPrice').value = '';

}

// 清空結果表格中的所有列，保留表頭
function clearTable() {
    const tableBody = document.getElementById('resultTable').getElementsByTagName('tbody')[0];
    while (tableBody.rows.length > 0) {
        tableBody.rows[0].remove();
    }

    // 重置序號計數器
    rowCount = 0;
}

// 選中一列，並填充輸入欄位
function selectRow(row) {
    selectedRow = row; // 設置選中的列
    document.getElementById('manufacturer').value = row.cells[2].textContent;
    document.getElementById('category').value = row.cells[3].textContent;
    document.getElementById('basePrice').value = row.cells[4].textContent;
    document.getElementById('sellingPrice').value = row.cells[5].textContent;
}

// 更新選中的列
function updateRow() {
    if (!selectedRow) { // 如果沒有選中任何列，執行以下程序
        alert('請選擇一列進行修改');
        return;
    }

    // 取得新的輸入值，並去除頭尾空白
    const manufacturer = document.getElementById('manufacturer').value.trim();
    const category = document.getElementById('category').value.trim();
    const basePrice = document.getElementById('basePrice').value.trim();
    const sellingPrice = document.getElementById('sellingPrice').value.trim();

    // 檢查製造商和類別是否為空白
    if (manufacturer === '' || category === '') {
        alert('製造商和類別不可空白');
        return;
    }

    // 更新選中的列中的資料
    selectedRow.cells[2].textContent = manufacturer;
    selectedRow.cells[3].textContent = category;
    selectedRow.cells[4].textContent = basePrice;
    selectedRow.cells[5].textContent = sellingPrice;

    // 清空輸入欄位
    clearFields();
}

// 刪除一列並更新序號
function deleteRow(row) {
    const table = document.getElementById('resultTable').getElementsByTagName('tbody')[0];
    table.deleteRow(row.rowIndex - 1); // 刪除該列
    rowCount--; // 減少序號計數器
    updateSerialNumbers(); // 更新序號
}

// 更新所有列的序號
function updateSerialNumbers() {
    const rows = document.getElementById('resultTable').getElementsByTagName('tbody')[0].rows;
    for (let i = 0; i < rows.length; i++) { // 從第一列開始更新序號
        rows[i].cells[1].textContent = i + 1; // 從 1 開始設置序號
    }
}

全域變數



const manufacturerInput = document.getElementById('manufacturer');
const categoryInput = document.getElementById('category');
const basePriceInput = document.getElementById('basePrice');
const sellingPriceInput = document.getElementById('sellingPrice');
const resultTableBody = document.getElementById('resultTable').getElementsByTagName('tbody')[0];

let rowCount = 0;
let selectedRow = null;

// 新增一列
function addRow() {
    // 取得使用者輸入的數值，並去除頭尾空白
    const manufacturer = manufacturerInput.value.trim();
    const category = categoryInput.value.trim();
    const basePrice = basePriceInput.value.trim();
    const sellingPrice = sellingPriceInput.value.trim();

    // 檢查製造商和類別是否為空白
    if (!manufacturer || !category) {
        alert('製造商和類別不可空白');
        return;
    }

    // 更新序號
    rowCount++;
    const row = resultTableBody.insertRow(); // 插入新列

    // 在新的一列的第一格中添加單選按鈕
    const cell1 = row.insertCell(0);
    const radio = document.createElement('input');
    radio.type = 'radio';
    radio.name = 'selectRow';
    radio.onclick = () => selectRow(row); // 點擊單選按鈕時選中該列
    cell1.appendChild(radio);

    // 在新的一列中插入序號、製造商、類別、底價和售價
    row.insertCell(1).textContent = rowCount;
    row.insertCell(2).textContent = manufacturer;
    row.insertCell(3).textContent = category;
    row.insertCell(4).textContent = basePrice;
    row.insertCell(5).textContent = sellingPrice;

    // 在新的一列的最後一格中添加刪除按鈕
    const cell7 = row.insertCell(6);
    const deleteButton = document.createElement('button');
    deleteButton.textContent = '刪除';
    deleteButton.onclick = () => deleteRow(row); // 點擊刪除按鈕時刪除該列
    cell7.appendChild(deleteButton);

    // 清空輸入欄位
    clearFields();
}

// 清空所有輸入欄位
function clearFields() {
    manufacturerInput.value = '';
    categoryInput.value = '';
    basePriceInput.value = '';
    sellingPriceInput.value = '';
}

// 清空結果表格中的所有列，保留表頭
function clearTable() {
    while (resultTableBody.rows.length > 0) {
        resultTableBody.rows[0].remove();
    }
    // 重置序號計數器
    rowCount = 0;
}

// 選中一列，並填充輸入欄位
function selectRow(row) {
    selectedRow = row; // 設置選中的列
    manufacturerInput.value = row.cells[2].textContent;
    categoryInput.value = row.cells[3].textContent;
    basePriceInput.value = row.cells[4].textContent;
    sellingPriceInput.value = row.cells[5].textContent;
}

// 更新選中的列
function updateRow() {
    if (!selectedRow) { // 如果沒有選中任何列，執行以下程序
        alert('請選擇一列進行修改');
        return;
    }

    // 取得新的輸入值，並去除頭尾空白
    const manufacturer = manufacturerInput.value.trim();
    const category = categoryInput.value.trim();
    const basePrice = basePriceInput.value.trim();
    const sellingPrice = sellingPriceInput.value.trim();

    // 檢查製造商和類別是否為空白
    if (!manufacturer || !category) {
        alert('製造商和類別不可空白');
        return;
    }

    // 更新選中的列中的資料
    selectedRow.cells[2].textContent = manufacturer;
    selectedRow.cells[3].textContent = category;
    selectedRow.cells[4].textContent = basePrice;
    selectedRow.cells[5].textContent = sellingPrice;

    // 清空輸入欄位
    clearFields();
}

// 刪除一列並更新序號
function deleteRow(row) {
    resultTableBody.deleteRow(row.rowIndex - 1); // 刪除該列
    rowCount--; // 減少序號計數器
    updateSerialNumbers(); // 更新序號
}

// 更新所有列的序號
function updateSerialNumbers() {
    const rows = resultTableBody.rows;
    for (let i = 0; i < rows.length; i++) { // 從第一列開始更新序號
        rows[i].cells[1].textContent = i + 1; // 從 1 開始設置序號
    }
}


// // 全域變數
// const manufacturerInput = document.getElementById('manufacturer');
// const categoryInput = document.getElementById('category');
// const basePriceInput = document.getElementById('basePrice');
// const sellingPriceInput = document.getElementById('sellingPrice');
// const resultTableBody = document.getElementById('resultTable').getElementsByTagName('tbody')[0];

// let rowCount = 0;
// let selectedRow = null;

// // 新增一列
// function addRow() {
//     // 取得使用者輸入的數值，並去除頭尾空白
//     const manufacturer = manufacturerInput.value.trim();
//     const category = categoryInput.value.trim();
//     const basePrice = basePriceInput.value.trim();
//     const sellingPrice = sellingPriceInput.value.trim();

//     // 檢查製造商和類別是否為空白
//     if (!manufacturer || !category) {
//         alert('製造商和類別不可空白');
//         return;
//     }

//     // 更新序號
//     rowCount++;
//     const row = resultTableBody.insertRow(); // 插入新列

//     // 在新的一列的第一格中添加單選按鈕
//     const cell1 = row.insertCell(0);
//     const radio = document.createElement('input');
//     radio.type = 'radio';
//     radio.name = 'selectRow';
//     radio.onclick = () => selectRow(row); // 點擊單選按鈕時選中該列
//     cell1.appendChild(radio);

//     // 在新的一列中插入序號、製造商、類別、底價和售價
//     row.insertCell(1).textContent = rowCount;
//     row.insertCell(2).textContent = manufacturer;
//     row.insertCell(3).textContent = category;
//     row.insertCell(4).textContent = basePrice;
//     row.insertCell(5).textContent = sellingPrice;

//     // 在新的一列的最後一格中添加刪除按鈕
//     const cell7 = row.insertCell(6);
//     const deleteButton = document.createElement('button');
//     deleteButton.textContent = '刪除';
//     deleteButton.onclick = () => deleteRow(row); // 點擊刪除按鈕時刪除該列
//     cell7.appendChild(deleteButton);

//     // 清空輸入欄位
//     clearFields();
// }

// // 清空所有輸入欄位
// function clearFields() {
//     manufacturerInput.value = '';
//     categoryInput.value = '';
//     basePriceInput.value = '';
//     sellingPriceInput.value = '';
// }

// // 清空結果表格中的所有列，保留表頭
// function clearTable() {
//     while (resultTableBody.rows.length > 0) {
//         resultTableBody.rows[0].remove();
//     }
//     // 重置序號計數器
//     rowCount = 0;
// }

// // 選中一列，並填充輸入欄位
// function selectRow(row) {
//     selectedRow = row; // 設置選中的列
//     manufacturerInput.value = row.cells[2].textContent;
//     categoryInput.value = row.cells[3].textContent;
//     basePriceInput.value = row.cells[4].textContent;
//     sellingPriceInput.value = row.cells[5].textContent;
// }

// // 更新選中的列
// function updateRow() {
//     // 檢查是否有選中一列
//     if (!selectedRow) { 
//         alert('請選擇一列進行修改');
//         return;
//     }

//     // 取得新的輸入值，並去除頭尾空白
//     const manufacturer = manufacturerInput.value.trim();
//     const category = categoryInput.value.trim();
//     const basePrice = basePriceInput.value.trim();
//     const sellingPrice = sellingPriceInput.value.trim();

//     // 檢查製造商和類別是否為空白
//     if (!manufacturer || !category) {
//         alert('製造商和類別不可空白');
//         return;
//     }

//     // 更新選中的列中的資料
//     selectedRow.cells[2].textContent = manufacturer;
//     selectedRow.cells[3].textContent = category;
//     selectedRow.cells[4].textContent = basePrice;
//     selectedRow.cells[5].textContent = sellingPrice;

//     // 清空輸入欄位
//     clearFields();

//     // 清除選擇的行
//     selectedRow = null;
// }

// // 刪除一列並更新序號
// function deleteRow(row) {
//     resultTableBody.deleteRow(row.rowIndex - 1); // 刪除該列
//     rowCount--; // 減少序號計數器
//     updateSerialNumbers(); // 更新序號

//     // 如果刪除的行是選中的行，則清除選擇
//     if (row === selectedRow) {
//         selectedRow = null;
//         clearFields(); // 清空輸入欄位
//     }
// }

// // 更新所有列的序號
// function updateSerialNumbers() {
//     const rows = resultTableBody.rows;
//     for (let i = 0; i < rows.length; i++) { // 從第一列開始更新序號
//         rows[i].cells[1].textContent = i + 1; // 從 1 開始設置序號
//     }
// }


