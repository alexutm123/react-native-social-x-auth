# react-native-social-x-auth

auth 2.0 x

## Installation

```sh
npm install react-native-social-x-auth
```

## Usage
You need to create an application and get the client_id

[developer.x](https://developer.x.com/en)

Mandatory for [iOS Universal Link](https://developer.apple.com/documentation/xcode/allowing-apps-and-websites-to-link-to-your-content/) and [Android App Link](https://developer.android.com/training/app-links?hl=en) for redirect or schema 

```js
import { useXAuth } from 'react-native-social-x-auth'

  const { startAuth, error } = useXAuth({
    clientId: 'client_id',
    redirectUri: 'redirect_uri',
    scopes: ['users.read', 'offline.access'],
    onSuccess: (code, codeVerifier) => {
      console.log('Authorization code received:', code, 'Code verifier:', codeVerifier);
    },
    onError: (err) => {
      console.error('Error:', err.message)
    },
  })
```

The result should be a code - which you can change to [access_token](https://docs.x.com/fundamentals/authentication/oauth-2-0/user-access-token) and use it to get the user data.


## X OAuth Documentation

[Authentication](https://docs.x.com/fundamentals/authentication/oauth-2-0/overview)

## License

MIT

