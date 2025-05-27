/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    const res = {};
    for (const str of strs) {
        const arr = [];
        for (const s of str) {
            const letterPosition = s.charCodeAt(0) - 'a'.charCodeAt(0);
            arr[letterPosition] = (arr[letterPosition] || 0) + 1;
        }
        const key = arr.join(',');
        res[key] = res[key] || [];
        res[key].push(str);
    }

    return Object.values(res);
};