
class HashMap {
    constructor() {
        this.map = {};
    }

    put(key, value) {
        if (this.map.hasOwnProperty(key)) {
            throw new Error("Key already exists");
        }
        this.map[key] = value;
    }

    get(key) {
        return this.map[key] || null;
    }

    contains(key) {
        return this.map.hasOwnProperty(key);
    }

    keys() {
        return Object.keys(this.map);
    }

    clear() {
        this.map = {};
    }
}

// 等待 DOM 內容加載完成
document.addEventListener('DOMContentLoaded', () => {
    const hashMap = new HashMap();
    const keyInput = document.getElementById('key');
    const valueInput = document.getElementById('value');
    const resultOutput = document.getElementById('result');

    document.getElementById('put').addEventListener('click', () => {
        const key = keyInput.value.trim();
        const value = valueInput.value;

        if (!key) {
            alert('Key 不能空白');
            return;
        }

        if (hashMap.contains(key)) {
            alert('Key 不能重覆');
            return;
        }

        hashMap.put(key, value);
        updateResult();
    });

    document.getElementById('clear').addEventListener('click', () => {
        hashMap.clear();
        keyInput.value = '';
        valueInput.value = '';
        updateResult();
    });

    function updateResult() {
        const entries = hashMap.keys().map(key => `${key}: ${hashMap.get(key)}`);
        resultOutput.textContent = entries.join('\n');
    }
});
