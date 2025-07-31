import { sha256 } from '@noble/hashes/sha2';
import base64 from 'react-native-base64'

function generateCodeVerifier(length = 43): string {
  const possible = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-._~';
  let verifier = '';
  for (let i = 0; i < length; i++) {
    verifier += possible.charAt(Math.floor(Math.random() * possible.length));
  }
  return verifier;
}

function base64UrlEncode(bytes: Uint8Array): string {
  const base64Str = base64.encodeFromByteArray(bytes);
  return base64Str.replace(/\+/g, '-').replace(/\//g, '_').replace(/=+$/, '');
}

function generateCodeChallenge(verifier: string): string {
  try {
    const data = new TextEncoder().encode(verifier); 
    const hash = sha256(data);
    return base64UrlEncode(hash).replace(/=/g, '');
  } catch (error) {
    console.error('Error in generateCodeChallenge:', error);
    throw error;
  }
}

export { generateCodeVerifier, generateCodeChallenge };
