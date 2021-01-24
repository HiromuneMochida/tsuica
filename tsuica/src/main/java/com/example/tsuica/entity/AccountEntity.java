package com.example.tsuica.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

/**
*
* @author hiromune mochida
* @version 2021/01/18
* アカウントエンティティクラス
*
*/
@Data
public class AccountEntity implements UserDetails {

 private final long serialVersionUID = 1L;

 /** 権限の種類 */
 //TODO 削除予定
 public enum Authority {
   ROLE_USER, ROLE_ADMIN
 }

 /** ユーザーネーム */
 private String userName;

 /** パスワード */
 private String password;

 /** 有効判定 */
 //private boolean enabled;

 /** 権限 */
 //private Authority role;
 private String role;

 /** 削除フラグ */
 private String delFlg;

 /** コンストラクタ */
 public AccountEntity(String userName, String password) {
   this.userName = userName;
   this.password = password;
   //this.enabled = true;
   this.role = "ROLE_USER";
   this.delFlg = "0";
   //TODO 削除予定
   //this.role = Authority.ROLE_USER;
 }

 public AccountEntity() {
 }

 /** ユーザーに与えられている権限リストを返却する */
 @Override
 public Collection<? extends GrantedAuthority> getAuthorities() {
   List<GrantedAuthority> authorities = new ArrayList<>();
   authorities.add(new SimpleGrantedAuthority(this.role.toString()));

   return authorities;
 }

 /** ユーザー名を返却する */
 @Override
 public String getUsername() {
   return userName;
 }

 /** アカウントの有効期限の状態を判定する */
 @Override
 public boolean isAccountNonExpired() {
   return true;
 }

 /** アカウントのロック状態を判定する */
 @Override
 public boolean isAccountNonLocked() {
   return true;
 }

 /** 資格情報の有効期限の状態を判定する */
 @Override
 public boolean isCredentialsNonExpired() {
   return true;
 }

 @Override
 public boolean isEnabled() {
   return true;
 }
}

