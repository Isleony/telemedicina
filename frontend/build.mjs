#!/usr/bin/env node
import { build } from 'vite';

(async () => {
  try {
    await build();
    process.exit(0);
  } catch (error) {
    console.error(error);
    process.exit(1);
  }
})();
