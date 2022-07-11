import React from 'react';

// import './FileLabel-cmp.css';

interface FileLabelCmpProps {
  fileTitle: string;
  iconImg?: string;
}

const FileLabelCmp: React.FC<FileLabelCmpProps> = ({ fileTitle, iconImg = "[F]" }) => {
  return <div className='file-label'>
    <img src={iconImg} className="file-label-icon" alt={fileTitle} />
    {fileTitle}
  </div>;
}

export default FileLabelCmp;
