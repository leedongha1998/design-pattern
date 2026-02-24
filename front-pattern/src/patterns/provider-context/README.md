# Provider / Context

## 실무 문제
- 테마/로케일/사용자 권한 같은 전역 상태가 props drilling을 유발

## 해결
- Provider로 전역 상태를 주입하고, 커스텀 훅으로 안전하게 접근
