import React from "react";
import { render } from "@testing-library/react";

import FileLabelCmp from "./FileLabel-cmp";

describe("FileLabelCmp", () => {
  test("renders the FileLabelCmp component", () => {
    render(<FileLabelCmp fileTitle="index.json" />);
  });
});