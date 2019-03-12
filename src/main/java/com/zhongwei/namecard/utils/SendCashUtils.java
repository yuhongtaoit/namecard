package com.zhongwei.namecard.utils;

import org.springframework.stereotype.Service;

import com.zhongwei.namecard.entity.CardMember;

@Service
public class SendCashUtils {

	
	public static void sendCash(CardMember cardMember) {
//		public function send_cash($order)
//		{
//			global $_W, $_GPC;
//			$userinfo = $_SESSION["userinfo"];
//			$userinfo = base64_decode($_SESSION["userinfo"]);
//			$userinfo = unserialize($userinfo);
//			if (!$userinfo["openId"]) {
//				return -2;
//			}
//			$_W["uniacid"] = $order["uniacid"];
//			$setting = uni_setting($_W["uniacid"], "payment");
//			if (!is_array($setting["payment"])) {
//				return 0;
//			}
//			$seting = $setting["payment"]["wechat"];
//			$sql = "SELECT `key`,`secret` FROM " . tablename("account_wxapp") . " WHERE `uniacid`=:uniacid";
//			$row = pdo_fetch($sql, array(":uniacid" => $_W["uniacid"]));
//			$paysetting["mchid"] = $seting["mchid"];
//			$paysetting["appid"] = $row["key"];
//			$paysetting["appsecret"] = $row["secret"];
//			$paysetting["shkey"] = $seting["signkey"];
//			$uniacid = $_W["uniacid"];
//			$base = pdo_fetch("SELECT * FROM " . tablename("dbs_masclwlcard_set") . " WHERE uniacid =:uniacid", array(":uniacid" => $_W["uniacid"]));
//			if (!$base["open_redpack"]) {
//				return -1;
//			}
//			if (!$order["source_id"]) {
//				return -3;
//			}
//			$source_membr = pdo_fetch("SELECT * FROM " . tablename("dbs_masclwlcard_card_member") . " WHERE uniacid =:uniacid and aid=:aid and id=:id and hmd_status=0 ", array(":uniacid" => $_W["uniacid"], ":aid" => $order["aid"], ":id" => $order["source_id"]));
//			if (empty($source_membr)) {
//				return -4;
//			}
//			$delta = 0.001;
//			$a = $base["redpack_min"];
//			$b = $base["redpack_max"];
//			if (abs($a - $b) < $delta) {
//				$fee = $base["redpack_min"] * 100;
//			} else {
//				$fee = mt_rand($a * 100, $b * 100);
//			}
//			$pars = array();
//			$pars[":uniacid"] = $_W["uniacid"];
//			$pars[":openid"] = $source_membr["openId"];
//			$pars[":m_id"] = $order["id"];
//			$pars[":source_id"] = $source_membr["id"];
//			$sql = "SELECT * FROM " . tablename("dbs_masclwlcard_cash") . " WHERE aid=:aid and source_id=:source_id and uniacid=:uniacid and m_id=:m_id and openid=:openid ";
//			$ret = pdo_fetch($sql, $pars);
//			if (!empty($ret) && $ret["status"] == 1) {
//				return -4;
//			}
//			if (empty($ret)) {
//				$r = array();
//				$r["uniacid"] = $uniacid;
//				$r["openid"] = $source_membr["openId"];
//				$r["m_id"] = $order["id"];
//				$r["source_id"] = $source_membr["id"];
//				$r["fee"] = $fee / 100;
//				list($msec, $sec) = explode(" ", microtime());
//				$orderid = date("YmdHis", $sec) . substr($msec, 2, 4);
//				$orderid = "niceyj" . $orderid;
//				$r["mch_billno"] = $orderid;
//				$r["log"] = '';
//				$r["create_t"] = time();
//				$r["success_t"] = 0;
//				$r["status"] = 0;
//				$r["ip"] = $_SERVER["REMOTE_ADDR"];
//				$ret = pdo_insert("dbs_masclwlcard_cash", $r);
//				if (!empty($ret)) {
//					$record_id = pdo_insertid();
//				} else {
//					return -5;
//				}
//				$mch_billno = $r["mch_billno"];
//			} else {
//				return -6;
//			}
//			$uniacid = $_W["uniacid"];
//			$url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
//			$pars = array();
//			$pars["mch_appid"] = $paysetting["appid"];
//			$pars["mchid"] = $paysetting["mchid"];
//			$pars["nonce_str"] = random(32);
//			$pars["partner_trade_no"] = $mch_billno;
//			$pars["openid"] = $source_membr["openId"];
//			$pars["check_name"] = "NO_CHECK";
//			$pars["amount"] = $fee;
//			$pars["desc"] = "您邀请" . $order["nickname"] . "得到" . $r["fee"] . "元";
//			$pars["spbill_create_ip"] = $_SERVER["REMOTE_ADDR"];
//			ksort($pars, SORT_STRING);
//			$string1 = '';
//			foreach ($pars as $k => $v) {
//				$string1 .= "{$k}={$v}&";
//			}
//			$string1 .= "key={$paysetting["shkey"]}";
//			$pars["sign"] = strtoupper(md5($string1));
//			$xml = array2xml($pars);
//			$extras = array();
//			$extras["CURLOPT_SSLCERT"] = MB_ROOT . "/cert/" . $uniacid . "/apiclient_cert.pem";
//			$extras["CURLOPT_SSLKEY"] = MB_ROOT . "/cert/" . $uniacid . "/apiclient_key.pem";
//			load()->func("communication");
//			$procResult = null;
//			$resp = ihttp_request($url, $xml, $extras);
//			if (is_error($resp)) {
//				$procResult = $resp;
//			} else {
//				$xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" . $resp["content"];
//				$dom = new \DOMDocument();
//				if ($dom->loadXML($xml)) {
//					$xpath = new \DOMXPath($dom);
//					$code = $xpath->evaluate("string(//xml/return_code)");
//					$ret = $xpath->evaluate("string(//xml/result_code)");
//					if (strtolower($code) == "success" && strtolower($ret) == "success") {
//						$procResult = true;
//					} else {
//						$error = $xpath->evaluate("string(//xml/err_code_des)");
//						$procResult = error(-2, $error);
//					}
//				} else {
//					$procResult = error(-1, "error response");
//				}
//			}
//			if (is_error($procResult)) {
//				$filters = array();
//				$filters["uniacid"] = $uniacid;
//				$filters["id"] = $record_id;
//				$rec = array();
//				$rec["log"] = $procResult["message"];
//				pdo_update("dbs_masclwlcard_cash", $rec, $filters);
//				return $procResult;
//			} else {
//				$filters = array();
//				$filters["uniacid"] = $uniacid;
//				$filters["id"] = $record_id;
//				$rec = array();
//				$rec["status"] = 1;
//				$rec["success_t"] = time();
//				pdo_update("dbs_masclwlcard_cash", $rec, $filters);
//				return true;
//			}
//		}
	}
}
