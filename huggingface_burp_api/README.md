# Hugging Face Inference API Integration for Burp Suite Extension

This project provides example code and guidance for integrating the Hugging Face Inference API with your Burp Suite extension for advanced vulnerability detection and confirmation.

## Setup

1. **Get Hugging Face API Token**
   - Go to https://huggingface.co/
   - Sign in to your account (or create one if needed)
   - Go to Settings -> Access Tokens
   - Create a new token with read access
   - Copy your API token

2. **Choose a Model**
   - Browse models at https://huggingface.co/models
   - Select a model suitable for your vulnerability detection needs
   - Copy the model ID (e.g., "bert-base-uncased")

## Java Integration Example

The `BurpExtensionInferenceExample.java` file provides example code for calling the Hugging Face Inference API from your Java-based Burp Suite extension.

1. Update the constants in the code:
```java
private static final String HF_API_TOKEN = "YOUR_HUGGING_FACE_API_TOKEN";
private static final String MODEL_ID = "YOUR_MODEL_ID";
```

2. Use the `analyzeWithHuggingFace` method in your Burp Suite extension:
```java
String result = BurpExtensionInferenceExample.analyzeWithHuggingFace(requestData);
```

## API Usage

The Inference API endpoint format is:
```
https://api-inference.huggingface.co/models/MODEL_ID
```

### Request Format
```json
{
  "inputs": "your text to analyze"
}
```

### Headers Required
- `Authorization: Bearer YOUR_API_TOKEN`
- `Content-Type: application/json`

### Example Response
The response format will depend on the model you're using. For text classification models, it might look like:
```json
[
  {
    "label": "LABEL",
    "score": 0.99
  }
]
```

## Notes
- Choose an appropriate model for vulnerability detection
- Handle API rate limits appropriately in your extension
- Consider error handling and retries for robustness
- Keep your API token secure and never commit it to version control

## Additional Resources
- [Hugging Face Inference API Documentation](https://huggingface.co/docs/api-inference/index)
- [Available Models](https://huggingface.co/models)
- [API Reference](https://huggingface.co/docs/api-inference/detailed_parameters)
