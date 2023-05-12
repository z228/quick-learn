<template>
	<view>
		<view class="main">
			<view class="title">
				{{article.title}}
			</view>
			
			<view v-for="(item,index) in englishArry">
				<view class="english" >
					{{item}}
				</view>
				<view class="showContent" @click="showContent(index)">
					<view class="textStyle">
						<view>点击空白处可显示翻译内容</view>
						<view class="el-icon-caret-bottom"></view>
					</view>
					<view class="chinese" :class="isActive[index] ? 'active' : '' ">
						{{chineseArry[index]}}
					</view>
				</view>	
			</view>
			<view class="foot_content">
				<rich-text :nodes="phrase" space="nbps"></rich-text>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				isActive:[],
				article:{},
				chineseArry:[],
				englishArry:[],
				phrase:""

			}
		},
		methods: {
			showContent(index){
				// this.isActive[index]=false;
				//如果用上面的方式，则页面不会马上响应
				this.$set(this.isActive,index,false);
			}
		},
		onLoad() {
			//接收上一个页面传来的参数
			var article=this.$route.query.article;
			this.article=article;
			let {chinese,english,phrase}=article;
			this.chineseArry=chinese.split("<br/>");
			this.englishArry=english.split("<br/>");
			this.phrase=phrase;
			for(let i=0;i<this.chineseArry.length;i++){
				this.isActive.push(true);
			}
		
		},
	}
</script>

<style lang="less">
.main{
	padding: 20rpx;
	background-color: #F1F3F4;
	.title{
		font-size: 24px;
		font-weight: bold;
		text-align: center;
	}
	.chinese{
		margin-bottom: 30rpx;
		font-family: 宋体;
		text-indent:2em;
		font-size: 16px;
	}
	.showContent{
		.english{
			font-family: Times New Roman;
			text-indent:2em;//首行缩进
			font-size: 16px;
			margin-bottom: 40rpx;
		}

		.textStyle{
			margin: 20rpx 0;
			text-align: center;
			font-size: 15px;
			color: #999;
		}
		.active{
			visibility: hidden;
		}
	}
	.foot_content{
	}
}

</style>
