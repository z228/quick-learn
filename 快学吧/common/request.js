// request.js
//公共的url
// const baseUrl = 'http://47.96.175.242:8081'  
const baseUrl = 'http://localhost:8081'  

const request = (options = {}) => {
	let header={...options.header}
	if(options.url!=="/user/login" || options.url!=="/user/register"){
		header["token"]=uni.getStorageSync("token");
	}
	
 // 在这里可以对请求头进行一些设置
//  options.header = {
// 		"Content-Type": "application/x-www-form-urlencoded"
// }
	return new Promise((resolve, reject) => {
		uni.request({
			url: baseUrl + options.url || '',
			method: options.type || 'GET',
			header:header || '',
			data: options.data || {},
			// header: options.header || {}      
		}).then(data => {
			let [err, res] = data;        
			resolve(res);
		}).catch(error => {
			reject(error)
		})
	});
}

const get = (url, data, options = {}) => {	
	options.type = 'GET';
	options.data = data;
	options.url = url;
	return request(options)
}

const post = (url, data, options = {}) => {
	options.type = 'POST';
	options.data = data;
	options.url = url;
	return request(options)
}


export default  {
	request,
	get,
	post
}

//使用格式：
// this.$request.get('/caller/getCallers.action', {
// 	// 传参参数名：参数值,如果没有，就不需要传
// 	// "username": "john",
// 	// "key": this.searchValue
// }).then(res => {
// 	// 打印调用成功回调
// 	console.log(res)
// 	this.productList = res;
// })